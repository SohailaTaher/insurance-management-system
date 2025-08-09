
import java.util.*;


class Feedback {
    private int feedbackID;
    private int clientID;
    private String feedbackText;
    private Date submissionDate;
    private int rating;

    public Feedback(int feedbackID, int clientID, String feedbackText, int rating) {
        this.feedbackID = feedbackID;
        this.clientID = clientID;
        this.feedbackText = feedbackText;
        this.rating = rating;
        this.submissionDate = new Date();
    }

    // Getters
    public int getFeedbackID() { return feedbackID; }
    public int getClientID() { return clientID; }
    public String getFeedbackText() { return feedbackText; }
    public Date getSubmissionDate() { return submissionDate; }
    public int getRating() { return rating; }
}

// Feedback Controller
class FeedbackController {
    private Map<Integer, Feedback> feedbacks;

    public FeedbackController() {
        this.feedbacks = (Map<Integer, Feedback>) new HashMap();
    }

    public Feedback submitFeedback(int clientID, String feedbackText, int rating) {
        int feedbackID = feedbacks.size() + 1;
        Feedback feedback = new Feedback(feedbackID, clientID, feedbackText, rating);
        feedbacks.put(feedbackID, feedback);
        return feedback;
    }

    public List<Feedback> getAllFeedback() {
        return new ArrayList<>(feedbacks.values());
    }

    public double getAverageRating() {
        return feedbacks.values().stream()
                .mapToInt(Feedback::getRating)
                .average()
                .orElse(0.0);
    }
}