package com.degtyarenko;

public class MainController {
    @InjectClass
    private Math math;

    public MainController() {
    }

    public Math getMath() {
        return math;
    }

}
