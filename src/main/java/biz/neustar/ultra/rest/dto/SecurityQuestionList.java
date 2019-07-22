package biz.neustar.ultra.rest.dto;

import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;

import java.util.LinkedList;
import java.util.List;

public class SecurityQuestionList {

    /**
     * list of all SecurityQuestions.
     */
    private List<SecurityQuestion> questions;

    /**
     * Empty constructor.
     */
    public SecurityQuestionList() {
        super();
        this.questions = new LinkedList<>();
    }

    /**
     * Parameterized constructor.
     *
     * @param questions
     */
    public SecurityQuestionList(List<SecurityQuestion> questions) {
        super();
        this.questions = questions;
    }

    /**
     * return SecurityQuestions.
     *
     * @return the questions
     */
    public final List<SecurityQuestion> getQuestions() {
        return questions;
    }

    /**
     * Set SecurityQuestions.
     *
     * @param questions the questions to set
     */
    public final void setQuestions(List<SecurityQuestion> questions) {
        this.questions = questions;
    }

    /*
     * (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public final String toString() {
        return MoreObjects.toStringHelper(this).add("questions", getQuestions()).toString();
    }

    /*
     * (non-Javadoc)
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode() {
        return Objects.hashCode(questions);
    }

    /*
     * (non-Javadoc)
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public boolean equals(Object object) {
        if (!(object instanceof SecurityQuestionList)) {
            return false;
        }
        SecurityQuestionList that = (SecurityQuestionList) object;
        return Objects.equal(this.questions, that.questions);
    }
}
