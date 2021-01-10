package pl.sda.livecodingspringcore.decorator;

import org.springframework.stereotype.Component;

@Component
public class SpaceRemovingDecorator implements StringDecorator {    //zad 5
    @Override
    public String decorate(String input) {
        return input.replaceAll(" +", " ").trim(); //regex ='więcej niż jedna spacja'
    }
}
