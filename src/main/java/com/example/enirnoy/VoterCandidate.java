package com.example.enirnoy;
//use database or soket
public class VoterCandidate {

        private final String election;
        private final String type;
        private final String name;
        private final String nid;

        public VoterCandidate(String election, String type, String name, String nid) {
            this.election = election;
            this.type = type;
            this.name = name;
            this.nid = nid;
        }

        public String getElection() {
            return election;
        }

        public String getType() {
            return type;
        }

        public String getName() {
            return name;
        }

        public String getNid() {
            return nid;
        }
    }


