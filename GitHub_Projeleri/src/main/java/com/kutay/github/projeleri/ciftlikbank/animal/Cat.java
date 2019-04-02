package com.kutay.github.projeleri.ciftlikbank.animal;

class Cat extends Animal implements IAnimal {

	@Override
	public String speak() {
		// TODO Auto-generated method stub
		return "miyav";
	}

	@Override
	public boolean isAlive() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean canFly() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean canSwim() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean hasTail() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public String nutrition() {
		// TODO Auto-generated method stub
		return "carnivore";
	}

	
}
