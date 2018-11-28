public class Park implements Gearbox{
    private boolean gas;
    private boolean breaking;
    private boolean direction;

    Park(boolean gas,boolean br){
        this.gas=gas;
        this.breaking=br;
    }
    @Override
    public void gas() {
        if (this.gas){
            this.gas=false;

        }
        else {
            this.gas=true;

        }

    }


    @Override
    public void breaking() {
        if (this.breaking){
            this.breaking=false;

        }
        else {
            this.breaking=true;
        }
    }

    @Override
    public boolean getDirection() {
        return direction;
    }

    @Override
    public void setDirection() {
        if(this.direction){
            this.direction=false;
        }
        else{
            this.direction=true;
        }
    }

    @Override
    public boolean getGas() {
        return this.gas;
    }

    @Override
    public boolean getBreaking() {
        return this.breaking;
    }
}
