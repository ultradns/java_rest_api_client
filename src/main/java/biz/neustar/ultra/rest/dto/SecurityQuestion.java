package biz.neustar.ultra.rest.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;

/**
 * Security Question.
 */
@JsonInclude(Include.NON_NULL)
public class SecurityQuestion {

    /**
     * The id for the security question.
     */
    private String id;

    /**
     * The text of the security question.
     */
    private String question;

    public SecurityQuestion() {
        super();
    }

    /**
     * Parameterized constructor.
     */
    public SecurityQuestion(String id, String question) {
        super();
        this.id = id;
        this.question = question;
    }

    /**
     * return question id.
     *
     * @return BigDecimal
     */
    public String getId() {
        return this.id;
    }

    /**
     * set question id.
     *
     * @param id - BigDecimal
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * return question description.
     *
     * @return String
     */
    public String getQuestion() {
        return this.question;
    }

    /**
     * Set question description.
     *
     * @param question - String
     */
    public void setQuestion(String question) {
        this.question = question;
    }

    /*
     * (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public final String toString() {
        return MoreObjects.toStringHelper(this).add("id", getId()).add("question", getQuestion()).toString();
    }

    /*
     * (non-Javadoc)
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode() {
        return Objects.hashCode(id, question);
    }

    /*
     * (non-Javadoc)
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public boolean equals(Object object) {
        if (!(object instanceof SecurityQuestion)) {
            return false;
        }
        SecurityQuestion that = (SecurityQuestion) object;
        return Objects.equal(this.id, that.id) && Objects.equal(this.question, that.question);
    }

}
