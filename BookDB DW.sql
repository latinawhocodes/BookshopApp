BEGIN TRANSACTION;
CREATE TABLE IF NOT EXISTS "Book" (
	"ISBN"	TEXT,
	"Name"	TEXT,
	"Description"	TEXT,
	"Price"	NUMERIC,
	"Author"	TEXT,
	"Genre"	TEXT,
	"Publisher"	TEXT,
	"YearPublished"	INTEGER,
	"CopiesSold"	INTEGER,
	"Rating"	NUMERIC,
	"AmountOfRates"	INTEGER,
	"Comment"	TEXT,
	PRIMARY KEY("ISBN")
);
INSERT INTO "Book" VALUES ('978-0553208849','Siddhartha','Story of Buddha.',5.95,'Herman Hesse','Philosophical','New Directions',1922,100000000,4.7,3275,'Book was great!');
INSERT INTO "Book" VALUES ('0-486-29256-8','Wuthering Heights','Story of jealousy and vengeance.',5.99,'Emily Brontë','Tragedy','Thomas Cautley Newby',1847,100000,4.6,2194,'Book was good.');
INSERT INTO "Book" VALUES ('978-0451191144','Atlas Shrugged','The role of man''s mind in existence.',8.49,'Ayn Rynd','Philosophical','Random House',1957,9000000,4.5,12270,'Book was alright.');
COMMIT;
