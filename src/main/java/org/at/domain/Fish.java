package org.at.domain;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue( "FISH" )
public class Fish extends Animal {
    private LivingEnv livingEnv;

    public Fish() {super();}

    public LivingEnv getLivingEnv() {
        return livingEnv;
    }

    public void setLivingEnv(LivingEnv livingEnv) {
        this.livingEnv = livingEnv;
    }
}
