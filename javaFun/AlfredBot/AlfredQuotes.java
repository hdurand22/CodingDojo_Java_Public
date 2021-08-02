import java.util.Date;

public class AlfredQuotes {
    public String basicGreeting() {
        return "Hello, lovely to see you. How are you?";
    }

    public String guestGreeting(String name, String dayPeriod) {
        return String.format("Good %s, %s.", dayPeriod, name);
    }

    public String dateAnnouncement() {
        Date date = new Date();
        return "Today's date is "+ date;
    }

    public String respondBeforeAlexis(String conversation) {
        int findAlexis = conversation.indexOf("Alexis");
        int findAlfred = conversation.indexOf("Alfred");
        if (findAlexis != -1) {
            return "Right away, sir. She certainly isn't sophisticated for something like that.";
        }
        else if (findAlfred != -1) {
            return "At your service.";
        }
        else {
            return "Right. And with that, I shall retire.";
        }
    }

    public String scream(String exclamation) {
        String scream = exclamation.toUpperCase();

        return scream;
    }
} 