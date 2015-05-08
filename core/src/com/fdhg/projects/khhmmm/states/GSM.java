package com.fdhg.projects.khhmmm.states;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.util.Stack;

// keep track of all game states created
// responsible for updating and rendering required game states (top of stack)
public class GSM {

    private Stack<State> states;

    public GSM() {
        states = new Stack<>();
    }

    public void push(State s) {
        states.push(s);
    }

    public void pop() {
        states.pop();
    }

    public void set(State s) {
        states.pop();
        states.push(s);
    }

    // update only top of stack
    public void update(float dt) {
        states.peek().update(dt);
    }

    // render only top of stack
    public void render(SpriteBatch sb) {
        states.peek().render(sb);
    }
}