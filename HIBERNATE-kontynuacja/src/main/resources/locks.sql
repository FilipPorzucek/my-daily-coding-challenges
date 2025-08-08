CREATE TABLE event(
eventId SERIAL not null,
eventName VARCHAR(32) not null,
dateTime TIMESTAMP WITH TIME ZONE not null,
capacity INT not null,
PRIMARY KEY(event_id),
UNIQUE(eventName)
);

CREATE TABLE ticket(
ticketId SERIAL not null,
firstName VARCHAR(32) not null,
lastName VARCHAR(32) not null,
eventId INT not null,
PRIMARY KEY(eventId),
CONSTRAINT fk_ticket_event
FOREIGN KEY (event_id)
REFERENCES event(event_id)

);