INSERT INTO households (eircode, number_of_occupants, max_number_of_occupants, owner_occupied) VALUES
                                                                                                  ('D02XY45', 3, 5, 1),
                                                                                                  ('A94B6F3', 4, 6, 0),
                                                                                                  ('T12AB34', 2, 4, 1),
                                                                                                  ('C15DE67', 5, 7, 1),
                                                                                                  ('F12GH89', 1, 2, 0),
                                                                                                  ('B78IJ01', 3, 5, 1),
                                                                                                  ('M34KL56', 4, 6, 0),
                                                                                                  ('P90QR78', 2, 4, 1),
                                                                                                  ('V23ST01', 5, 7, 1),
                                                                                                  ('X45UV67', 1, 2, 0),
                                                                                                  ('Y67WX89', 3, 5, 1),
                                                                                                  ('Z01YZ23', 4, 6, 0),
                                                                                                  ('Q45AB78', 2, 4, 1),
                                                                                                  ('R67CD01', 5, 7, 1),
                                                                                                  ('S23EF45', 1, 2, 0);

INSERT INTO pets (name, animal_type, breed, age, household_eircode) VALUES ('Buddy', 'Dog', 'Golden Retriever', 3, 'D02XY45');
INSERT INTO pets (name, animal_type, breed, age, household_eircode) VALUES ('Mittens', 'Cat', 'Siamese', 2, 'D02XY45');
INSERT INTO pets (name, animal_type, breed, age, household_eircode) VALUES ('Charlie', 'Dog', 'Beagle', 4, 'T12AB34');
INSERT INTO pets (name, animal_type, breed, age, household_eircode) VALUES ('Whiskers', 'Cat', 'Persian', 5, 'C15DE67');
INSERT INTO pets (name, animal_type, breed, age, household_eircode) VALUES ('Coco', 'Rabbit', 'Holland Lop', 1, 'C15DE67');
INSERT INTO pets (name, animal_type, breed, age, household_eircode) VALUES ('Goldie', 'Fish', 'Goldfish', 1, 'V23ST01');
INSERT INTO pets (name, animal_type, breed, age, household_eircode) VALUES ('Polly', 'Bird', 'Parakeet', 2, 'Q45AB78');
INSERT INTO pets (name, animal_type, breed, age, household_eircode) VALUES ('Max', 'Dog', 'German Shepherd', 5, 'Q45AB78');
INSERT INTO pets (name, animal_type, breed, age, household_eircode) VALUES ('Luna', 'Cat', 'Maine Coon', 3, 'R67CD01');
INSERT INTO pets (name, animal_type, breed, age, household_eircode) VALUES ('Nibbles', 'Hamster', 'Syrian Hamster', 1, 'S23EF45');

INSERT INTO myusers (username, password, first_name, last_name, county, role, enabled, account_non_expired, credentials_non_expired, account_non_locked)
VALUES ('nadia.ravani@hotmail.com', '$2a$10$jPOV8aXOKupAi7UCJVvMaeEzBXjjLEblskQkB3ZAtNww2ATQjp8QK', 'Nadia', 'Ravani', 'Valencia',
        'ROLE_ADMIN', TRUE, TRUE, TRUE, TRUE);

INSERT INTO myusers (username, password, first_name, last_name, county, role, enabled, account_non_expired, credentials_non_expired, account_non_locked)
VALUES ('bob.squarepants@example.com', '$2a$10$jPOV8aXOKupAi7UCJVvMaeEzBXjjLEblskQkB3ZAtNww2ATQjp8QK', 'Bob', 'Squarepants', 'Bikini Bottom', 'ROLE_USER', TRUE, TRUE, TRUE, TRUE);

INSERT INTO myusers (username, password, first_name, last_name, county, role, enabled, account_non_expired, credentials_non_expired, account_non_locked)
VALUES ('john.snow@example.com', '$2a$10$jPOV8aXOKupAi7UCJVvMaeEzBXjjLEblskQkB3ZAtNww2ATQjp8QK', 'John', 'Snow', 'North', 'ROLE_USER', TRUE, TRUE, TRUE, TRUE);

INSERT INTO myusers (username, password, first_name, last_name, county, role, enabled, account_non_expired, credentials_non_expired, account_non_locked)
VALUES ('coriolanus.snow@example.com', '$2a$10$jPOV8aXOKupAi7UCJVvMaeEzBXjjLEblskQkB3ZAtNww2ATQjp8QK', 'Coriolanus', 'Snow', 'The Capitol', 'ROLE_ADMIN', TRUE, TRUE, TRUE, FALSE);

INSERT INTO myusers (username, password, first_name, last_name, county, role, enabled, account_non_expired, credentials_non_expired, account_non_locked)
VALUES ('brock.purdy@example.com', '$2a$10$jPOV8aXOKupAi7UCJVvMaeEzBXjjLEblskQkB3ZAtNww2ATQjp8QK', 'Brock', 'Purdy', 'San Francisco', 'ROLE_ADMIN', TRUE, TRUE, TRUE, FALSE);

-- I used the same password as in the lecture so that I don't have to encode one