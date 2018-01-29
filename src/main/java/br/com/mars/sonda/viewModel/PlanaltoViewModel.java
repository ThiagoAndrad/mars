package br.com.mars.sonda.viewModel;

import javax.validation.constraints.Min;

public class PlanaltoViewModel {

    @Min(0)
    private int x;

    @Min(0)
    private int y;

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public Planalto toPlanalto() {

        return new Planalto(x, y);
    }
}
