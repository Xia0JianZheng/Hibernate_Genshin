CREATE TABLE region(
id_region PRIMARY KEy,
region_name text
);

CREATE TABLE element(
id_element PRIMARY KEY,
element_name text
);

CREATE TABLE character(
id_character serial PRIMARY KEY,
character_name text,
character_rarity text,
character_image text,
character_description text,
element_name text REFERENCES element (element_name),
region_name text REFERENCES region (region_name),
weapon_type text
);

CREATE TABLE weapon(
id_weapon serial PRIMARY KEY,
weapon_name text,
weapon_rarity INT,
weapon_image text,
weapon_description text,
weapon_type text,
base_atk text,
character_id INT
);

CREATE TABLE artifact(
id_artifactSet serial,
set_name text,
flower_of_life text,
img_flower_of_life text,
plume_of_death text,
img_plume_of_death text,
sands_of_eon text,
img_sands_of_eon text,
goblet_of_eonothem text,
img_goblet_of_eonothem text,
circlet_of_logos text,
img_circlet_of_logos text,
x2_bonus text,
x4_bonus text
);
