package DAY6.HAS_A_3;

class Battery{
    int capacityMaH;
    Battery(int capacityMaH){
        this.capacityMaH=capacityMaH;
    }

    void drain(){
        System.out.println("Battery used"+(capacityMaH-100));
    }
}

class Camera{
   int pix;
    Camera(int pix){
        this.pix=pix;
    }
    void takePhoto(){
        System.out.println("click a photo wity" + pix + "sensor" );
    }
}

class Phone{
    String brand;
    Battery battery;
    Camera camera;

    Phone(String brand, Battery battery, Camera camera){
        this.brand = brand;
        this.battery = battery;
        this.camera = camera;
    }
    void snapPicture(){
        System.out.println("[" + brand + "]" + "is active");
        camera.takePhoto();
        battery.drain();
    }

}
