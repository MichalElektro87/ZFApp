package com.michalkosalka;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.utils.viewport.FitViewport;

public class WelcomeScreen implements Screen {

    private ZFAppWithAndroid app;
    private Stage stage;
    private ZFLogoActor zfLogoActor;

    public WelcomeScreen (ZFAppWithAndroid app) {
        this.app = app;
        this.stage = new Stage(new FitViewport(800, 480));
        this.zfLogoActor = new ZFLogoActor();

        stage.addActor(zfLogoActor);
        zfLogoActor.addAction(Actions.alpha(0f));
        zfLogoActor.addAction(Actions.sequence(Actions.alpha(1f, 4f)));
        zfLogoActor.addAction(Actions.after(Actions.run(new Runnable() {
            @Override
            public void run() {
                app.setScreen(new MenuScreen(app));
            }
        })));
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(1f, 1f, 1f, 1f);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        stage.act();
        stage.draw();
    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

    }
}
