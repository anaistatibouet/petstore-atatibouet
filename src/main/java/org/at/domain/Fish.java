package org.at.domain;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Entity
@DiscriminatorValue( "Fish" )
public class Fish extends Animal {
    @Enumerated(EnumType.STRING)
    private LivingEnv livingEnv;

    public Fish() {super();}

    public LivingEnv getLivingEnv() {
        return livingEnv;
    }

    public void setLivingEnv(LivingEnv livingEnv) {
        this.livingEnv = livingEnv;
    }
}
