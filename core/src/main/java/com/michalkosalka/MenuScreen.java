package com.michalkosalka;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Event;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.utils.viewport.FitViewport;

public class MenuScreen implements Screen {

    private ZFAppWithAndroid app;
    private Stage stage;
    private Skin skin;
    private Table table;
    private Label infoLabel;
    private TextField textFieldLogin;
    private TextField textFieldPassword;
    private TextButton textButton;



    public MenuScreen(ZFAppWithAndroid app) {
        this.app = app;
        this.stage = new Stage(new FitViewport(800, 480));
        this.skin = new Skin(Gdx.files.internal("2/uiskin.json"));
        this.textFieldLogin = new TextField("", skin);
        this.textFieldPassword = new TextField("", skin);
        this.textButton = new TextButton("Confirm", skin);
        this.infoLabel = new Label("Login or password not correct...", skin);
        this.infoLabel.setVisible(false);
        this.infoLabel.setColor(Color.RED);
        this.table = new Table(skin);


        //table.setDebug(true);
        table.background("window");
        table.setFillParent(true);
        table.add(new Label("Login", skin)).pad(20);
        table.add(textFieldLogin).width(100);
        table.row();
        table.add(new Label("Password", skin)).pad(20);
        table.add(textFieldPassword).width(100);
        table.row();
        table.add(textButton).colspan(2);
        table.row();
        table.add(infoLabel).colspan(4);


        stage.addActor(table);
        Gdx.input.setInputProcessor(stage);

        stage.setKeyboardFocus(textFieldLogin);
        textFieldLogin.getOnscreenKeyboard();

        textButton.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                if (textFieldLogin.getText().equals("admin")&& textFieldPassword.getText().equals("admin")) {
                    Gdx.app.exit();
                    System.exit(0);
                }

                else {
                    infoLabel.setVisible(true);
                }

            }
        });

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                int i = 0;
                while (i < 10) {
                    try {
                        Thread.sleep(1000);


                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }

            }
        });

        thread.start();
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
        stage.getViewport().setScreenSize(width, height);
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
