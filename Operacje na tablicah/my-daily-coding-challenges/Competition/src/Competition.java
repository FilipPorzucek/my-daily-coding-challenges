class Competition {
    private String name;
    private Participant[] participants;
    private int ageLimit;
    private int size;

    public Competition(String name, int maxParticipants, int ageLimit) {
        this.name = name;
        if(ageLimit<=0)
            throw new IllegalArgumentException("Liczba musi byc dodatnia");
        this.ageLimit = ageLimit;
        this.participants = new Participant[maxParticipants];
    }

    void addParticipant(Participant participant) throws  MaxCompetitorsException{
        if (participant.getAge() < ageLimit) {
            throw new AgeViolationException("Wiek jest zby młody");
        }
        if(participants.length==size){
            throw new MaxCompetitorsException("Nie ma juz miejsc");
        }isDuplicated(participant);
        participants[size] = participant;
        size++;
    }

   private void isDuplicated(Participant participant){
        for(int i=0;i<size;i++){
           if(participants[i].getDocumentId().equals(participant.getDocumentId()));
           throw new DuplicateException(participant);
        }
   }

    boolean hasFreeSpots() {
        return size < participants.length;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Zawody ")
                .append(name)
                .append("\n")
                .append("Liczba uczestników: ").append(size);
        for (int i = 0; i < size; i++) {
            builder.append("\n");
            builder.append(" > ");
            builder.append(participants[i].toString());
        }
        return builder.toString();
    }
}