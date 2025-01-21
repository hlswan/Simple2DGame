package UI.dialogue;

import UI.UI;
import main.GamePanel;

import java.awt.*;

public class DialogueHandler extends UI {
    Graphics2D g2;
    GamePanel gp;
    Font ariel_40;


    public DialogueHandler(GamePanel gp) {
        super(gp);
        this.gp = gp;
        ariel_40 = new Font("Ariel", Font.PLAIN, 40);
    }

    @Override
    public void draw(Graphics2D g2) {
        this.g2 = g2;
        g2.setFont(ariel_40);
        g2.setColor(Color.white);

        if (gp.gameState == gp.dialogueState) {
            System.out.println("Drawing Dialogue");
            drawDialogue();
        }
    }

    private void drawDialogue() {
        String text = "Hi there!";
        int x = GamePanel.screenWidth/3;
        int y = GamePanel.screenHeight-GamePanel.screenHeight/4;
        g2.drawString(text, x, y);
    }
}
