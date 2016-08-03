package se02;

import java.util.ArrayList;

public class Employee {

	private ArrayList<Stationery> stationeries;

	public Employee() {
		this.stationeries = new ArrayList<Stationery>();
	}

	public ArrayList<Stationery> getStationeries() {
		return stationeries;
	}

	public void setStationeries(ArrayList<Stationery> stationers) {
		this.stationeries = stationers;
	}


	public void addStationery(Stationery st){
		stationeries.add(st);
	}

	public void removeStatoinery(int index){
		stationeries.remove(index);
	}

	public int getCostOfStationers(){

		int fullCost = 0;

		for(Stationery stn : this.stationeries){
			fullCost += stn.getCost() * stn.getCount();
		}
		return fullCost;
	}
}
