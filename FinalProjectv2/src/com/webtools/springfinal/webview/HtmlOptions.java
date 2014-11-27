package com.webtools.springfinal.webview;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import com.webtools.html.SelectedItem;

public abstract class HtmlOptions {

private static SelectedItem[] titleOptions=new SelectedItem[11];
private static List<SelectedItem> stateOptions=new ArrayList<SelectedItem>(50);
	
	/**
 * @return the stateOptions
 */
public static List<SelectedItem> getStateOptions() {
	return stateOptions;
}

	static{
		titleOptions[0]=new SelectedItem();
		titleOptions[1]=new SelectedItem();
		titleOptions[2]=new SelectedItem();
		titleOptions[3]=new SelectedItem();
		titleOptions[4]=new SelectedItem();
		titleOptions[5]=new SelectedItem();
		titleOptions[6]=new SelectedItem();
		titleOptions[7]=new SelectedItem();
		titleOptions[8]=new SelectedItem();
		titleOptions[9]=new SelectedItem();
		titleOptions[10]=new SelectedItem();
	
		titleOptions[0].setLabel("Mr.");
		titleOptions[0].setValue("Mr.");
		titleOptions[1].setLabel("Miss");
		titleOptions[1].setValue("Miss");
		titleOptions[2].setLabel("Dr.");
		titleOptions[2].setValue("Dr.");
		titleOptions[3].setLabel("Mrs.");
		titleOptions[3].setValue("Mrs.");
		titleOptions[4].setLabel("Ms.");
		titleOptions[4].setValue("Ms.");
		titleOptions[5].setLabel("Mstr");
		titleOptions[5].setValue("Mstr");
		titleOptions[6].setLabel("Rev.");
		titleOptions[6].setValue("Rev.");
		titleOptions[7].setLabel("Capt.");
		titleOptions[7].setValue("Capt.");
		titleOptions[8].setLabel("Maj.");
		titleOptions[8].setValue("Maj.");
		titleOptions[9].setLabel("Capt.");
		titleOptions[9].setValue("Capt.");
		titleOptions[10].setLabel("Gen.");
		titleOptions[10].setValue("Gen.");
		
		stateOptions.add(new SelectedItem("AK"));
		stateOptions.add(new SelectedItem("AL"));
		stateOptions.add(new SelectedItem("AR"));
		stateOptions.add(new SelectedItem("AZ"));
		stateOptions.add(new SelectedItem("CA"));
		stateOptions.add(new SelectedItem("CO"));
		stateOptions.add(new SelectedItem("CT"));
		stateOptions.add(new SelectedItem("DC"));
		stateOptions.add(new SelectedItem("DE"));
		stateOptions.add(new SelectedItem("FL"));
		stateOptions.add(new SelectedItem("GA"));
		stateOptions.add(new SelectedItem("HI"));
		stateOptions.add(new SelectedItem("IA"));
		stateOptions.add(new SelectedItem("ID"));
		stateOptions.add(new SelectedItem("IL"));
		stateOptions.add(new SelectedItem("IN"));
		stateOptions.add(new SelectedItem("KS"));
		stateOptions.add(new SelectedItem("KY"));
		stateOptions.add(new SelectedItem("LA"));
		stateOptions.add(new SelectedItem("MA"));
		stateOptions.add(new SelectedItem("MD"));
		stateOptions.add(new SelectedItem("ME"));
		stateOptions.add(new SelectedItem("MI"));
		stateOptions.add(new SelectedItem("MN"));
		stateOptions.add(new SelectedItem("MO"));
		stateOptions.add(new SelectedItem("MS"));
		stateOptions.add(new SelectedItem("MT"));
		stateOptions.add(new SelectedItem("NC"));
		stateOptions.add(new SelectedItem("ND"));
		stateOptions.add(new SelectedItem("NE"));
		stateOptions.add(new SelectedItem("NH"));
		stateOptions.add(new SelectedItem("NJ"));
		stateOptions.add(new SelectedItem("NM"));
		stateOptions.add(new SelectedItem("NV"));
		stateOptions.add(new SelectedItem("NY"));
		stateOptions.add(new SelectedItem("OH"));
		stateOptions.add(new SelectedItem("OK"));
		stateOptions.add(new SelectedItem("OR"));
		stateOptions.add(new SelectedItem("PA"));
		stateOptions.add(new SelectedItem("RI"));
		
		stateOptions.add(new SelectedItem("SC"));
		stateOptions.add(new SelectedItem("SD"));
		stateOptions.add(new SelectedItem("TN"));
		stateOptions.add(new SelectedItem("TX"));
		stateOptions.add(new SelectedItem("UT"));
		stateOptions.add(new SelectedItem("VA"));
		stateOptions.add(new SelectedItem("VT"));
		stateOptions.add(new SelectedItem("WA"));
		stateOptions.add(new SelectedItem("WI"));
		stateOptions.add(new SelectedItem("WV"));
		stateOptions.add(new SelectedItem("WY"));

		
		
	}
	
	public static SelectedItem[] getTitleOptions()
	{
		return titleOptions;
	}
}
