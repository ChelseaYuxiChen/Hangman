package eightball;

import java.awt.FlowLayout;
import javax.swing.*;


/**
 * The view for the eight ball program.
 */
public class EightBallView extends JFrame implements EightBallViewInterface {


  private JLabel answerLabel;

  private final JButton askButton;

  private final JTextField questionTextField;

  private Language language = Language.English;

  private final JLabel currentLanguage;

  private int lastAnswer = -2;

  private final JButton languageButton;

  /**
   * Constructs a new EightBallView object.
   *
   * @param title the caption for the view.
   */
  public EightBallView(String title) {
    super(title);

    setSize(400, 500);
    setLocation(200, 200);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    JPanel panel = new JPanel();
    panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

    JLabel instructionLabel = new JLabel("Ask a question and click the button to get an answer.");
    panel.add(instructionLabel);


    // Create a new panel for labels 2 and 3
    JPanel inputPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));

    // Add another label
    JLabel label4 = new JLabel("Question:");
    inputPanel.add(label4);
    // Add text input
    questionTextField = new JTextField(30);
    inputPanel.add(questionTextField);


    panel.add(inputPanel);
    // Add button next to text input
    askButton = new JButton("Ask");
    inputPanel.add(askButton);

    JPanel answerPanel = new JPanel((new FlowLayout(FlowLayout.LEFT)));
    JLabel label5 = new JLabel("Answer:");
    answerPanel.add(label5);
    answerLabel = new JLabel("");
    answerPanel.add(answerLabel);

    panel.add(answerPanel);

    // Create a new panel for the exit button
    JPanel exitPanel = new JPanel();
    exitPanel.setLayout(new BoxLayout(exitPanel, BoxLayout.X_AXIS));


    languageButton = new JButton("Change Language");
    languageButton.setActionCommand("Language Button");
    exitPanel.add(languageButton);

    currentLanguage = new JLabel("");
    languageButton.addActionListener(e -> {
      this.changeLanguage();
      this.updateLanguage();
    });
    this.updateLanguage();
    // Add horizontal glue
    exitPanel.add(Box.createHorizontalGlue());


    exitPanel.add(currentLanguage);

    // Add horizontal glue
    exitPanel.add(Box.createHorizontalGlue());

    JButton exitButton = new JButton("Exit");
    exitButton.setActionCommand("Exit Button");
    exitPanel.add(exitButton);
    // add the call back to the exit button that will close the window
    exitButton.addActionListener(e -> System.exit(0));
    panel.add(exitPanel);

    this.add(panel);
    pack();
    setVisible(true);
  }

  /**
   * Register callbacks
   *
   * @param controller the controller to register callbacks with.
   */
  public void registerCallbacks(EightBallControllerInterface controller) {
    askButton.addActionListener(e -> {
      String question = this.questionTextField.getText();
      int answer = controller.askQuestion(question);
      setAnswer(answer);
    });
    // add a call back to the enter key
    questionTextField.addActionListener(e -> {
      String question = this.questionTextField.getText();
      int answer = controller.askQuestion(question);
      setAnswer(answer);
    });
  }

  /**
   * Gets the answer to the question.
   * The answers are:
   * "Yes"
   * "No"
   * "Maybe"
   * "Outlook not so good"
   * "Signs point to yes"
   * "Cannot predict now"
   * "Don't count on it"
   * "Very doubtful"
   * "It is certain"
   * "As I see it, yes"
   *
   * @param answer the answer to the question.
   */
  private void setAnswer(int answer) {
    this.lastAnswer = answer;
    if (this.language == Language.English) {
      setEnglishAnswer(answer);
    } else {
      setSpanishAnswer(answer);
    }
  }

  /**
   * Sets the answer to the question in Spanish.
   *
   * @param answer the answer to the question.
   */
  private void setSpanishAnswer(int answer) {
    String message = "";
    switch (answer) {
      case -2:
        message = "¡No has hecho una pregunta!";
        break;
      case -1:
        message = "Si no haces una pregunta: No obtendrás una respuesta.";
        break;
      case 0:
        message = "Sí";
        break;
      case 1:
        message = "No";
        break;
      case 2:
        message = "Quizás";
        break;
      case 3:
        message = "Las perspectivas no son buenas";
        break;
      case 4:
        message = "Los signos apuntan a sí";
        break;
      case 5:
        message = "No se puede predecir ahora";
        break;
      case 6:
        message = "No cuentes con ello";
        break;
      case 7:
        message = "Muy dudoso";
        break;
      case 8:
        message = "Es cierto";
        break;
      case 9:
        message = "Según lo veo, sí";
        break;
      default:
        message = "Error";
    }
    this.answerLabel.setText(message);
  }

  /**
   * Sets the answer to the question in English.
   *
   * @param answer the answer to the question.
   */
  private void setEnglishAnswer(int answer) {
    String message = "";
    switch (answer) {
      case -2:
        message = "You have not asked a question!";
        break;
      case -1:
        message = "If you don't ask a question: You won't get an answer.";
        break;
      case 0:
        message = "Yes";
        break;
      case 1:
        message = "No";
        break;
      case 2:
        message = "Maybe";
        break;
      case 3:
        message = "Outlook not so good";
        break;
      case 4:
        message = "Signs point to yes";
        break;
      case 5:
        message = "Cannot predict now";
        break;
      case 6:
        message = "Don't count on it";
        break;
      case 7:
        message = "Very doubtful";
        break;
      case 8:
        message = "It is certain";
        break;
      case 9:
        message = "As I see it, yes";
        break;

      default:
        message = "Error";
    }
    this.answerLabel.setText(message);
  }


  private void changeLanguage() {
    // toggle the language
    if (this.language == Language.English) {
      this.language = Language.Spanish;
    } else {
      this.language = Language.English;
    }
  }

  private void updateLanguage() {
    switch (this.language) {
      case English:
        this.currentLanguage.setText("Language: English");
        this.languageButton.setText("Change Language");
        break;
      case Spanish:
        this.currentLanguage.setText("Idioma: Español");
        this.languageButton.setText("Cambiar Idioma");
        break;
      default:
        this.currentLanguage.setText("Current Language: English");
    }


    setAnswer(this.lastAnswer);


  }

}
