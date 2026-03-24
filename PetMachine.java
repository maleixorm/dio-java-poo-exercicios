public class PetMachine {
    private boolean clean;
    private int water;
    private int shampoo;
    private Pet pet;

    public void takeAShower() {
        if (this.pet == null){
            System.out.println("Coloque o pet na máquina para iniciar o banho");
            return;
        }
        this.water -= 10;
        this.shampoo -= 2;
        pet.setClean(true);
        System.out.println("O pet " + pet.getName() + " está limpo.");
    }

    public void addWater() {
        if (water == 30) {
            System.out.println("A capacidade máxima de água da máquina foi atingida.");
            return;
        }
        water += 2;
    }

    public void addShampoo() {
        if (shampoo == 10) {
            System.out.println("A capacidade máxima de shampoo da máquina foi atingida.");
            return;
        }
        shampoo += 2;
    }

    public int getWater() {
        return water;
    }

    public int getShampoo() {
        return shampoo;
    }

    public boolean hasPet() {
        return pet != null;
    }

    public void setPet(Pet pet) {
        if (!this.clean) {
            System.out.println("A máquina está suja. Para colocar um pet é necessário limpá-la.");
        }
        if (hasPet()) {
            System.out.println("O pet " + this.pet.getName() + " está na máquina nesse momento");
            return;
        }
        this.pet = pet;
    }

    public void removePet() {
        this.clean = this.pet.isClean();
        System.out.println("O pet " + this.pet.getName() + " está limpo.");
        this.pet = null;
    }

    public void wash() {
        this.water -= 3;
        this.shampoo -= 1;
        this.clean = true;
        System.out.println("A máquina está limpa!");
    }
}
