public class GameCharacter {

    private String attackType;

    public GameCharacter(String attackType) {
        this.attackType = attackType;
    }

    public void performAttack() {

        if (attackType.equals("SWORD")) {
            System.out.println("Attacking with a sword!");
        } 
        else if (attackType.equals("BOW")) {
            System.out.println("Attacking with a bow!");
        } 
        else if (attackType.equals("MAGIC")) {
            System.out.println("Casting a magic spell!");
        }
    }
}