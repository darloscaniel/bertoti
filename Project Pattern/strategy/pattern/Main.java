public class Main {

    public static void main(String[] args) {

        GameCharacter character = new GameCharacter(new SwordAttack());

        character.performAttack(); // Sword

        character.setAttackStrategy(new MagicAttack());

        character.performAttack(); // Magic
    }
}