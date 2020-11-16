package com.mauroPignatta;

import com.mauroPignatta.config.Configuration;

public class Main {

    public static void main(String[] args) {
        Configuration.init();
	    Visualizer visualizer = new Visualizer(Visualizer.UPS);
    }

}
