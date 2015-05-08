package com.fdhg.projects.khhmmm.ui;

// custom  xy-centered box class
// libgdx default box class is bottom-left-centered
public class Box {

    protected float x;
    protected float y;
    protected float width;
    protected float height;

    // checks is a certain point is contained inside a box
    public boolean contains(float x, float y) {
        return x > this.x - width / 2 &&
                x < this.x + width / 2 &&
                y > this.y - height / 2 &&
                y < this.y + height / 2;
    }
}
