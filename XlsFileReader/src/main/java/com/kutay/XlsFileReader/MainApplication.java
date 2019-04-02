package com.kutay.XlsFileReader;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.lang.Object;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.phexum.sdk.data.DataModel;
import com.phexum.sdk.io.ExcelFileReader;
import com.phexum.sdk.io.ExcelFileWriter;
import com.phexum.sdk.io.FileRow;
import com.phexum.sdk.io.FileRowConverter;
import com.phexum.sdk.io.ObjectArrayConverter;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

public class MainApplication {

	public static void main(String[] args) {

		try {

			ExcelFileReader<ReadDataRow> reader = new ExcelFileReader<>("./files/generic_tokenlist.xls");
			reader.accept(new FileRowConverter<ReadDataRow>() {

				@Override
				public ReadDataRow convert(FileRow r) {
					ReadDataRow dr = new ReadDataRow();
					dr.setText(r.get("text"));
					dr.setExpectedRoot(r.get("expected_root"));
					dr.setExpectedNegative(r.get("expected_negative"));
					dr.setExpectedVerb(r.get("expected_verb"));
					return dr;

				}

			});

			List<ReadDataRow> rows = reader.readAll();

			Client client = Client.create();

			WebResource webResource = client.resource("http://52.163.123.38:2000/ParserService/parse");
			Gson gson = new GsonBuilder().create();

			int n = rows.size();
			int i = 0;
			for (int m = 0; m < n; m++) {
				if (rows.get(m).getExpectedVerb().equals("true") || rows.get(m).getExpectedVerb().equals("false")) {

					++i;
				}
			}
			System.out.println("Output from Server .... \n");
			List<WrittenDataRow> ar = new ArrayList<>();
			for (int z = 0; z < i; z++) {
				WrittenDataRow propWDR = new WrittenDataRow();
				String input;
				input = gson.toJson(rows.get(z));
				ClientResponse response = webResource.type("application/json").post(ClientResponse.class, input);
				String output = response.getEntity(String.class);
				DataModel dt = gson.fromJson(output, DataModel.class);
				Map responseObj = (Map) dt.get("response");
				List<Map<String, String>> tokensObj = (List) responseObj.get("tokens");
				System.out.println(tokensObj);
				String.valueOf(tokensObj.get(0).get("verb"));
				String temp1 = tokensObj.get(0).get("root");
				String temp2 = String.valueOf(tokensObj.get(0).get("verb"));
				String temp3 = String.valueOf(tokensObj.get(0).get("negative"));
				propWDR.setActualRoot(temp1);
				propWDR.setActualVerb(temp2);
				propWDR.setActualNegative(temp3);
				propWDR.setText(rows.get(z).getText());
				propWDR.setExpectedRoot(rows.get(z).getExpectedRoot());
				propWDR.setExpectedVerb(rows.get(z).getExpectedVerb());
				propWDR.setExpectedNegative(rows.get(z).getExpectedNegative());
				System.out.println(propWDR);
				ar.add(propWDR);
			}

			ExcelFileWriter<WrittenDataRow> writer = new ExcelFileWriter<>("./files/writedTokenList.xls");

			writer.accept(new ObjectArrayConverter<WrittenDataRow>() {

				@Override
				public Object[] convert(WrittenDataRow propWDR) {

					String text = propWDR.getText();
					String expRoot = propWDR.getExpectedRoot();
					String expVerb = propWDR.getExpectedVerb();
					String expNegative = propWDR.getExpectedNegative();
					String actRoot = propWDR.getActualRoot();
					String actVerb = propWDR.getActualVerb();
					String actNegative = propWDR.getActualNegative();
					Object[] objects = new Object[] { text, expRoot, expVerb, expNegative, actRoot, actVerb,
							actNegative };
					return objects;
				}

			});

			writer.writeRaw(new Object[] { "TEXT", "EXPECTED_ROOT", "EXPECTED_VERB", "EXPECTED_NEGATIVE", "ACTUAL_ROOT",
					"ACTUAL_VERB", "ACTUAL_NEGATIVE" });

			for (int it = 0; it < ar.size(); it++) {
				if (ar.get(0).getExpectedRoot() == ar.get(it).getActualRoot()) {
					ar.get(it).setActualRoot(ar.get(it).getActualRoot() + " - √");
				} else {
					ar.get(it).setActualRoot(ar.get(it).getActualRoot() + " - X");
				}

				if (ar.get(it).getExpectedVerb() == ar.get(it).getActualVerb()) {
					ar.get(it).setActualVerb(ar.get(it).getActualVerb() + " - √");
				} else {
					ar.get(it).setActualVerb(ar.get(it).getActualVerb() + " - X");
				}

				if (ar.get(it).getExpectedNegative() == ar.get(it).getActualNegative()) {
					ar.get(it).setActualNegative(ar.get(it).getActualNegative() + " - √");
				} else {
					ar.get(it).setActualNegative(ar.get(it).getActualNegative() + " - X");
				}
			}

			writer.write(ar);

			writer.close();

		} catch (Exception e) {

			e.printStackTrace();

		}

	}

}