USE brewlog;

INSERT INTO beers (name, type, size, volume_remaining, original_gravity, alcohol, date, brewer, selected) VALUES
  ('Drøgne Ø', 'Porter', 25, 25, 1050, 5, CURDATE(), 1, true),
  ('Valhalla', 'Black IPA', 50, 25, 1080, 8, CURDATE(), 1, false),
  ('Dronebrygg', 'Pils', 25, 25, 1050, 5, CURDATE(), 1, false),
  ('Portermand', 'Porter', 25, 10, 1058, 6, CURDATE(), 1, false);