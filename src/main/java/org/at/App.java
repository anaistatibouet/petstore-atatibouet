package org.at;

import org.at.domain.Fish;
import org.at.domain.LivingEnv;

public class App {
    public static void main(String[] args) {
        Fish fish = new Fish();
        fish.setLivingEnv(LivingEnv.fresh_Water);
    }
}
