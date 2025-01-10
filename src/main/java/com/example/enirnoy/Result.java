package com.example.enirnoy;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Result {



        private final StringProperty position;
        private final StringProperty candidate;
        private final StringProperty votes;

        public Result(String position, String candidate, String votes) {
            this.position = new SimpleStringProperty(position);
            this.candidate = new SimpleStringProperty(candidate);
            this.votes = new SimpleStringProperty(votes);
        }

        // Getters and Property Methods for Binding
        public String getPosition() {
            return position.get();
        }

        public void setPosition(String position) {
            this.position.set(position);
        }

        public StringProperty positionProperty() {
            return position;
        }

        public String getCandidate() {
            return candidate.get();
        }

        public void setCandidate(String candidate) {
            this.candidate.set(candidate);
        }

        public StringProperty candidateProperty() {
            return candidate;
        }

        public String getVotes() {
            return votes.get();
        }

        public void setVotes(String votes) {
            this.votes.set(votes);
        }

        public StringProperty votesProperty() {
            return votes;
        }
    }

