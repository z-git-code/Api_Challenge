DROP TABLE IF EXISTS testalert;
CREATE TABLE testalert (
  alert_id varchar(255) NOT NULL,
  service_id varchar(255),
  service_name varchar(255),
  model varchar(255),
  alert_type varchar(255),
  alert_ts varchar(255),
  severity varchar(255),
  team_slack varchar(255),
  PRIMARY KEY (alert_id)
);