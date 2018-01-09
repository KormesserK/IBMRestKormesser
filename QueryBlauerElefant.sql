drop table if exists result;
drop table if exists team;


CREATE TABLE team (
	estyear integer PRIMARY KEY,
	name varchar(40) NOT NULL
	
);

CREATE TABLE result (
	primkey integer PRIMARY KEY,
	teamone integer UNIQUE references team(estyear),
	teamtwo integer UNIQUE references team(estyear) check(teamone != teamtwo),
	goalsteamone integer,
	goalsteamtwo integer,
	dateof Date
);

