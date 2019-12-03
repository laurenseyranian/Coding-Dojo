package com.chughes.ninjagold.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;
import org.springframework.web.context.WebApplicationContext;

@Service
@Scope(value = WebApplicationContext.SCOPE_SESSION, proxyMode = ScopedProxyMode.TARGET_CLASS)
public class GoldService {
	
	private ArrayList <String> activities = new ArrayList <String>();
	
	private int gold;
	
	public int getGold() {
		return gold;
	}
	
	public void processMoney(String hidden) {
		
		if (hidden.equals("farm")) {
			int farmGold = new Random().nextInt(10) + 10;
			gold += farmGold;
			activities.add(0, "You earned " + farmGold + " from the farm. (" + new SimpleDateFormat("MM.dd.yyyy 'at' HH:mm a").format(new Date()) + ")");
		}
		if (hidden.equals("cave")) {
			int caveGold = new Random().nextInt(5) + 5;
			gold += caveGold;
			activities.add(0, "You earned " + caveGold + " from the cave. (" + new SimpleDateFormat("MM.dd.yyyy 'at' HH:mm a").format(new Date()) + ")");
		}
		if (hidden.equals("house")) {
			int houseGold = new Random().nextInt(2) + 3;
			gold += houseGold;
			activities.add(0, "You earned " + houseGold + " from the house. (" + new SimpleDateFormat("MM.dd.yyyy 'at' HH:mm a").format(new Date()) + ")");
		}
		if (hidden.equals("casino")) {
			int casinoGold= new Random().nextInt(100) - 50;
			gold += casinoGold;
			if (casinoGold < 0) {
				activities.add(0, "You lost " + casinoGold + " from the casino. (" + new SimpleDateFormat("MM.dd.yyyy 'at' HH:mm a").format(new Date()) + ")");
			}
			else {
				activities.add(0, "You earned " + casinoGold + " from the casino. (" + new SimpleDateFormat("MM.dd.yyyy 'at' HH:mm a").format(new Date()) + ")");
			}

		}
		
	}
	public ArrayList <String> getActivity() {
		return activities;
	}
	public void reset() {
		gold = 0;
		activities.clear();
	}	
}
