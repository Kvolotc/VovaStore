package store.persistence.model;


public class MailSender {

    private String subject;
    private String text;
    private String to;
    
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public String getTo() {
		return to;
	}
	public void setTo(String to) {
		this.to = to;
	}
	@Override
	public String toString() {
		return "MailSender [subject=" + subject + ", text=" + text + ", to=" + to + "]";
	}
    
	
}
