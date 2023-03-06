package com.michalkosalka;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;

public class ZFLogoActor extends Actor {
    private TextureRegion zfLogoRegion;

    public ZFLogoActor() {
        zfLogoRegion = new TextureRegion(new Texture(Gdx.files.internal("ZF_Official_Logo.png")));
        setWidth(zfLogoRegion.getRegionWidth());
        setHeight(zfLogoRegion.getRegionHeight());
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        super.draw(batch, parentAlpha);

        Color c = getColor();
        batch.setColor(c.r,c.g,c.b,c.a);
        batch.draw(zfLogoRegion, getX() + getStage().getWidth() / 2 - getWidth() / 2, getY(), getOriginX(), getOriginY(),
                getWidth(), getHeight(), getScaleX(), getScaleY(), getRotation());
    }
}
