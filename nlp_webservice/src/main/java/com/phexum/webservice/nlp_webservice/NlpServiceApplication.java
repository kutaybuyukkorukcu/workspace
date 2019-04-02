package com.phexum.webservice.nlp_webservice;

import java.util.Iterator;

import com.phexum.sdk.data.DataModel;
import com.phexum.sdk.nlp.IParser;
import com.phexum.sdk.nlp.rule.IRuleExecutor;
import com.phexum.sdk.nlp.token.Token;
import com.phexum.sdk.nlp.token.TokenList;
import com.phexum.sdk.platform.INlpClient;
import com.phexum.sdk.platform.api.PhexumApi;
import com.phexum.sdk.platform.application.service.PhexumEndPoint;
import com.phexum.sdk.platform.application.service.PhexumService;

@PhexumService(name = "Nlp_Service")
public class NlpServiceApplication {

	INlpClient nlp = PhexumApi.getInstance().getNlpClient();
	IParser parser = nlp.createParser(new IRuleExecutor() {}, true);

	@PhexumEndPoint(path = "parse")
	public DataModel parse(DataModel request) {
		DataModel response = DataModel.create("number", 2, "number2", 3);
		String text = request.getAs("text");
		
		TokenList list = parser.parse(text);
		
		for (Iterator<Token> iterator = list.iterator(); iterator.hasNext();) {
			Token t = iterator.next();
			System.out.println(t.getText() + " - " + t.getTagType());
		}
		
		for(Token t : list)
		response.put("first", t.getMeta().getRoot());
		
		return response;
		}
			
	}

