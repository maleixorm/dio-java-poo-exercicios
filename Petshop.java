import java.util.Scanner;

public class Petshop {
    private final static Scanner scanner = new Scanner(System.in);
    private final static PetMachine petMachine = new PetMachine();

    public static void main(String[] args) {
        var option = -1;
        do {
            System.out.println("=== Escolha uma das opções ===");
            System.out.println("==============================");
            System.out.println("1 - Dar banho no pet.");
            System.out.println("2 - Abastecer a máquina com água.");
            System.out.println("3 - Abastecer a máquina com shampoo.");
            System.out.println("4 - Verificar a água da máquina.");
            System.out.println("5 - Verificar o shampoo da máquina.");
            System.out.println("6 - Verificar se tem pet na máquina.");
            System.out.println("7 - Colocar o pet na máquina.");
            System.out.println("8 - Retirar a pet da máquina.");
            System.out.println("9 - Limpar a máquina.");
            System.out.println("0 - Sair.");
            option = scanner.nextInt();

            switch (option) {
                case 1 -> petMachine.takeAShower();
                case 2 -> setWater();
                case 3 -> setShampoo();
                case 4 -> verifyWater();
                case 5 -> verifyShampoo();
                case 6 -> checkIfHasPet();
                case 7 -> setPetInPetMachine();
                case 8 -> petMachine.removePet();
                case 9 -> petMachine.wash();
                case 0 -> System.exit(0);
                default -> System.out.println("Opção Inválida!");
            }
        } while (true);
    }

    private static void setWater() {
        System.out.println("Inserindo água na máquina.");
        petMachine.addWater();
    }

    private static void setShampoo() {
        System.out.println("Inserindo shampoo na máquina.");
        petMachine.addShampoo();
    }

    private static void verifyWater() {
        var amout = petMachine.getWater();
        System.out.println("A máquina está no momento com " + amout + " litros de agua.");
    }

    private static void verifyShampoo() {
        var amout = petMachine.getShampoo();
        System.out.println("A máquina está no momento com " + amout + " litros de shampoo.");
    }

    private static void checkIfHasPet() {
        var hasPet = petMachine.hasPet();
        System.out.println(hasPet ? "Tem pet na máquina." : "Não tem pet na máquina.");
    }

    public static void setPetInPetMachine() {
        var name = "";
        while (name == null || name.isEmpty()) {
            System.out.println("Informe o nome do pet: ");
            name = scanner.next();
        }
        var pet = new Pet(name);
        petMachine.setPet(pet);
        System.out.println("O pet " + pet.getName() + " foi colocado na máquina.");
    }
}
