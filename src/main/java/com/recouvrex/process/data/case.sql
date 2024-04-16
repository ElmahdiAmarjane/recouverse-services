-- the code generated for creating the table is 
CREATE TABLE public.collect_case (
  id INT8 NOT NULL DEFAULT unique_rowid(),
  case_id VARCHAR(255) NULL,
  commission_amount DECIMAL(38,2) NULL,
  contributor BYTES NULL,
  insurance_settlement_amout DECIMAL(38,2) NULL,
  interest_amount DECIMAL(38,2) NULL,
  penalty_amount DECIMAL(38,2) NULL,
  principal_amount DECIMAL(38,2) NULL,
  start_date DATE NULL,
  total_amount DECIMAL(38,2) NULL,
  user_id INT8 NULL,
  procedure_id INT8 NULL,
  status_id INT8 NULL,
  thirdparty_id INT8 NULL,
  CONSTRAINT collect_case_pkey PRIMARY KEY (id ASC),
  CONSTRAINT fkdy1dawy44t8cvhn0ydlu2o18w FOREIGN KEY (user_id) REFERENCES public.recouvrex_user(id),
  CONSTRAINT fk5s4sp4p5v5rd5ymtshyyov5mi FOREIGN KEY (procedure_id) REFERENCES public.procedure(id),
  CONSTRAINT fkc33r9nb6l6e8wql5d2fx8qpqq FOREIGN KEY (status_id) REFERENCES public.status(id),
  CONSTRAINT fko50idam2uatuc6bevs7vhjhf5 FOREIGN KEY (thirdparty_id) REFERENCES public.thirdparty(id)
)


-- To create a new case in the collect_case table, you'll need to provide values 
-- for the columns that are not automatically generated or have defaults. 
-- You should also ensure that the values you insert for the foreign
-- keys (user_id, procedure_id, status_id, thirdparty_id) correspond to actual records
--  in the respective referenced tables (public.recouvrex_user, public.procedure, public.status,
--   public.thirdparty).
INSERT INTO public.collect_case (
    case_id,
    commission_amount,
    contributor, -- This is a BYTES field, which usually represents binary data
    insurance_settlement_amout,
    interest_amount,
    penalty_amount,
    principal_amount,
    start_date,
    total_amount,
    user_id,
    procedure_id,
    status_id,
    thirdparty_id
) VALUES (
    'CASE12345', -- case_id example
    1500.00, -- commission_amount example
    '\\xDEADBEEF', -- contributor example as a binary data placeholder
    250.00, -- insurance_settlement_amout example
    100.00, -- interest_amount example
    50.00, -- penalty_amount example
    10000.00, -- principal_amount example
    '2024-01-01', -- start_date example
    10900.00, -- total_amount example (sum of all amounts, adjust as necessary)
    1, -- user_id example, assuming a record with this ID exists in public.recouvrex_user
    2, -- procedure_id example, assuming a record with this ID exists in public.procedure
    3, -- status_id example, assuming a record with this ID exists in public.status
    4 -- thirdparty_id example, assuming a record with this ID exists in public.thirdparty
);


INSERT INTO public.collect_case (
    case_id,
    commission_amount,
    contributor,
    insurance_settlement_amout,
    interest_amount,
    penalty_amount,
    principal_amount,
    start_date,
    total_amount,
    user_id,
    procedure_id,
    status_id,
    thirdparty_id
) VALUES 
    ('CASE1001', 1500.00, null, 250.00, 100.00, 50.00, 10000.00, '2024-01-01', 10900.00, 1, 1, 3, 4),
    ('CASE1002', 1600.00, null, 260.00, 110.00, 60.00, 11000.00, '2024-01-02', 12030.00, 2, 2, 4, 5),
    ('CASE1003', 1700.00, null, 270.00, 120.00, 70.00, 12000.00, '2024-01-03', 13160.00, 1, 3, 5, 6),
    
    ('CASE1004', 1800.00, null, 280.00, 130.00, 80.00, 13000.00, '2024-01-04', 15290.00, 1, 4, 6, 7),
    ('CASE1005', 1900.00, null, 290.00, 140.00, 90.00, 14000.00, '2024-01-05', 16420.00, 1, 5, 7, 8),
    ('CASE1006', 2000.00, null, 300.00, 150.00, 100.00, 15000.00, '2024-01-06', 17550.00, 1, 6, 8,8),
    ('CASE1007', 2100.00, null, 310.00, 160.00, 110.00, 16000.00, '2024-01-07', 18680.00, 1, 7, 9, 8),
    ('CASE1008', 2200.00, null, 320.00, 170.00, 120.00, 17000.00, '2024-01-08', 19810.00, 1, 8, 1, 8),
    ('CASE1009', 2300.00, null, 330.00, 180.00, 130.00, 18000.00, '2024-01-09', 20940.00, 1, 9, 1, 8),
    ('CASE1010', 2400.00, null, 340.00, 190.00, 140.00, 19000.00, '2024-01-10', 22070.00, 1, 1, 2, 8),
    ('CASE1011', 2500.00, null, 350.00, 200.00, 150.00, 20000.00, '2024-01-11', 23200.00, 1, 1, 3, 8),
    ('CASE1012', 2600.00, null, 360.00, 210.00, 160.00, 21000.00, '2024-01-12', 24330.00, 1, 2, 4, 8),
    ('CASE1013', 2700.00, null, 370.00, 220.00, 170.00, 22000.00, '2024-01-13', 25460.00, 1, 3, 5, 8),
    ('CASE1014', 2800.00, null, 380.00, 230.00, 180.00, 23000.00, '2024-01-14', 26590.00, 1, 4, 6, 8),
    ('CASE1015', 2900.00, null, 390.00, 240.00, 190.00, 24000.00, '2024-01-15', 27720.00, 1, 5, 7, 8),
    ('CASE1016', 3000.00, null, 400.00, 250.00, 200.00, 25000.00, '2024-01-16', 28850.00, 1, 6, 8, 8),
    ('CASE1017', 3100.00, null, 410.00, 260.00, 210.00, 26000.00, '2024-01-17', 29980.00, 1, 7, 9, 8),
   
    -- Add more rows for the remaining cases...
    -- ('CASE1040', 2000.00, null, 300.00, 150.00, 100.00, 13000.00, '2024-01-20', 15550.00, 2, 4, 2, 3),

    ('CASE1041', 2400.00, null, 300.00, 150.00, 100.00, 13000.00, '2024-01-21', 15550.00, 1, 5, 3, 4),
    ('CASE1042', 6600.00, null, 300.00, 150.00, 100.00, 13000.00, '2024-01-22', 15550.00, 1, 6, 4, 5),
    ('CASE1043', 2700.00, null, 300.00, 150.00, 100.00, 13000.00, '2024-01-23', 15550.00, 1, 7, 5, 6),
    ('CASE1044', 5500.00, null, 300.00, 150.00, 100.00, 13000.00, '2024-01-24', 15550.00, 1, 8, 6, 7),
    ('CASE1046', 5600.00, null, 300.00, 150.00, 100.00, 13000.00, '2024-01-26', 15550.00, 1, 5, 8, 9),
    ('CASE1047', 21900.00, null, 300.00, 150.00, 100.00, 13000.00, '2024-01-27', 15550.00, 1, 8, 9, 10),
    ('CASE1048', 9900.00, null, 300.00, 150.00, 100.00, 13000.00, '2024-01-28', 15550.00, 2, 4, 5, 11),
    ('CASE1049', 1100.00, null, 300.00, 150.00, 100.00, 13000.00, '2024-01-29', 15550.00, 2, 5, 1, 2),
    ('CASE1050', 3100.00, null, 300.00, 150.00, 100.00, 13000.00, '2024-01-10', 15550.00, 2, 2, 2, 3),

    ('CASE1051', 2100.00, null, 320.00, 160.00, 110.00, 13000.00, '2024-02-10', 15690.00, 1, 2, 3, 4),
    ('CASE1052', 2200.00, null, 340.00, 170.00, 120.00, 13000.00, '2024-02-11', 15830.00, 2, 3, 4, 5),
    ('CASE1053', 2300.00, null, 360.00, 180.00, 130.00, 13000.00, '2024-02-12', 15970.00, 1, 4, 5, 6),
    ('CASE1054', 2400.00, null, 380.00, 190.00, 140.00, 13000.00, '2024-02-13', 16110.00, 1, 5, 6, 7),
    ('CASE1055', 2500.00, null, 400.00, 200.00, 150.00, 13000.00, '2024-02-14', 16250.00, 1, 6, 7, 8),
    ('CASE1056', 2600.00, null, 420.00, 210.00, 160.00, 13000.00, '2024-02-15', 16390.00, 1, 7, 8, 9),
    ('CASE1057', 2700.00, null, 440.00, 220.00, 170.00, 13000.00, '2024-02-16', 16530.00, 1, 8, 9, 10),
    ('CASE1058', 2800.00, null, 460.00, 230.00, 180.00, 13000.00, '2024-02-17', 16670.00, 1, 9, 5, 1),
    ('CASE1059', 2900.00, null, 480.00, 240.00, 190.00, 13000.00, '2024-02-18', 16810.00, 1, 2, 1, 2),
    ('CASE1060', 3000.00, null, 500.00, 250.00, 200.00, 13000.00, '2024-02-19', 16950.00, 1, 1, 2, 11);


-- inserting cases for user with id 1
INSERT INTO public.collect_case (
    case_id,
    commission_amount,
    contributor,
    insurance_settlement_amout,
    interest_amount,
    penalty_amount,
    principal_amount,
    start_date,
    total_amount,
    user_id,
    procedure_id,
    status_id,
    thirdparty_id
) VALUES 
    ('CASE1001', 1500.00, null, 250.00, 100.00, 50.00, 10000.00, '2024-01-01', 10900.00, 5, 1, 3, 4),
    ('CASE1002', 1600.00, null, 260.00, 110.00, 60.00, 11000.00, '2024-01-02', 12030.00, 5, 2, 4, 5),
    ('CASE1003', 1700.00, null, 270.00, 120.00, 70.00, 12000.00, '2024-01-03', 13160.00, 5, 3, 5, 6),
    
    ('CASE1004', 1800.00, null, 280.00, 130.00, 80.00, 13000.00, '2024-01-04', 15290.00, 5, 4, 6, 7),
    ('CASE1005', 1900.00, null, 290.00, 140.00, 90.00, 14000.00, '2024-01-05', 16420.00, 5, 5, 7, 8),
    ('CASE1006', 2000.00, null, 300.00, 150.00, 100.00, 15000.00, '2024-01-06', 17550.00, 5, 6, 8,8),
    ('CASE1007', 2100.00, null, 310.00, 160.00, 110.00, 16000.00, '2024-01-07', 18680.00, 5, 7, 9, 8),
    ('CASE1008', 2200.00, null, 320.00, 170.00, 120.00, 17000.00, '2024-01-08', 19810.00, 5, 8, 1, 8),
    ('CASE1009', 2300.00, null, 330.00, 180.00, 130.00, 18000.00, '2024-01-09', 20940.00, 5, 9, 1, 8),
    ('CASE1010', 2400.00, null, 340.00, 190.00, 140.00, 19000.00, '2024-01-10', 22070.00, 5, 1, 2, 8),
    ('CASE1011', 2500.00, null, 350.00, 200.00, 150.00, 20000.00, '2024-01-11', 23200.00, 5, 1, 3, 8),
    ('CASE1012', 2600.00, null, 360.00, 210.00, 160.00, 21000.00, '2024-01-12', 24330.00, 5, 2, 4, 8),
    ('CASE1013', 2700.00, null, 370.00, 220.00, 170.00, 22000.00, '2024-01-13', 25460.00, 5, 3, 5, 8),
    ('CASE1014', 2800.00, null, 380.00, 230.00, 180.00, 23000.00, '2024-01-14', 26590.00, 5, 4, 6, 8),
    ('CASE1015', 2900.00, null, 390.00, 240.00, 190.00, 24000.00, '2024-01-15', 27720.00, 5, 5, 7, 8),
    ('CASE1016', 3000.00, null, 400.00, 250.00, 200.00, 25000.00, '2024-01-16', 28850.00, 5, 6, 8, 8),
    ('CASE1017', 3100.00, null, 410.00, 260.00, 210.00, 26000.00, '2024-01-17', 29980.00, 5, 7, 9, 8),
   
    -- Add more rows for the remaining cases...
    -- ('CASE1040', 2000.00, null, 300.00, 150.00, 100.00, 13000.00, '2024-01-20', 15550.00, 2, 4, 2, 3),

    ('CASE1041', 2400.00, null, 300.00, 150.00, 100.00, 13000.00, '2024-01-21', 15550.00, 5, 5, 3, 4),
    ('CASE1042', 6600.00, null, 300.00, 150.00, 100.00, 13000.00, '2024-01-22', 15550.00, 5, 6, 4, 5),
    ('CASE1043', 2700.00, null, 300.00, 150.00, 100.00, 13000.00, '2024-01-23', 15550.00, 5, 7, 5, 6),
    ('CASE1044', 5500.00, null, 300.00, 150.00, 100.00, 13000.00, '2024-01-24', 15550.00, 5, 8, 6, 7),
    ('CASE1046', 5600.00, null, 300.00, 150.00, 100.00, 13000.00, '2024-01-26', 15550.00, 5, 5, 8, 9),
    ('CASE1047', 21900.00, null, 300.00, 150.00, 100.00, 13000.00, '2024-01-27', 15550.00,5, 8, 9, 10),
    ('CASE1048', 9900.00, null, 300.00, 150.00, 100.00, 13000.00, '2024-01-28', 15550.00, 5, 4, 5, 11),
    ('CASE1049', 1100.00, null, 300.00, 150.00, 100.00, 13000.00, '2024-01-29', 15550.00, 5, 5, 1, 2),
    ('CASE1050', 3100.00, null, 300.00, 150.00, 100.00, 13000.00, '2024-01-10', 15550.00, 5, 2, 2, 3),

    ('CASE1051', 2100.00, null, 320.00, 160.00, 110.00, 13000.00, '2024-02-10', 15690.00, 5, 2, 3, 4),
    ('CASE1052', 2200.00, null, 340.00, 170.00, 120.00, 13000.00, '2024-02-11', 15830.00, 5, 3, 4, 5),
    ('CASE1053', 2300.00, null, 360.00, 180.00, 130.00, 13000.00, '2024-02-12', 15970.00, 5, 4, 5, 6),
    ('CASE1054', 2400.00, null, 380.00, 190.00, 140.00, 13000.00, '2024-02-13', 16110.00, 5, 5, 6, 7),
    ('CASE1055', 2500.00, null, 400.00, 200.00, 150.00, 13000.00, '2024-02-14', 16250.00, 5, 6, 7, 8),
    ('CASE1056', 2600.00, null, 420.00, 210.00, 160.00, 13000.00, '2024-02-15', 16390.00, 5, 7, 8, 9),
    ('CASE1057', 2700.00, null, 440.00, 220.00, 170.00, 13000.00, '2024-02-16', 16530.00, 5, 8, 9, 10),
    ('CASE1058', 2800.00, null, 460.00, 230.00, 180.00, 13000.00, '2024-02-17', 16670.00, 5, 9, 5, 1),
    ('CASE1059', 2900.00, null, 480.00, 240.00, 190.00, 13000.00, '2024-02-18', 16810.00, 5, 2, 1, 2),
    ('CASE1060', 3000.00, null, 500.00, 250.00, 200.00, 13000.00, '2024-02-19', 16950.00, 5, 1, 2, 11);











