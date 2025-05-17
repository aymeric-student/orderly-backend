-- V1__Create_initial_schema.sql
-- Migration initiale pour créer la structure de base

-- Table des utilisateurs
CREATE TABLE users (
                       id UUID DEFAULT gen_random_uuid() PRIMARY KEY,
                       username VARCHAR(20) UNIQUE NOT NULL,
                       email VARCHAR(100) UNIQUE NOT NULL,
                       password VARCHAR(255) NOT NULL,
                       is_active BOOLEAN DEFAULT true,
                       created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                       updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- Table des restaurants
CREATE TABLE restaurants (
                             id UUID DEFAULT gen_random_uuid() PRIMARY KEY,
                             name VARCHAR(100) NOT NULL,
                             address VARCHAR(255) NOT NULL,
                             opening_hours VARCHAR(100) NOT NULL,
                             created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                             updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- Table des settings
CREATE TABLE settings (
                          id UUID DEFAULT gen_random_uuid() PRIMARY KEY,
                          restaurant_id UUID UNIQUE NOT NULL,
                          enable_online_ordering BOOLEAN DEFAULT false,
                          on_site BOOLEAN DEFAULT true,
                          take_away BOOLEAN DEFAULT false,
                          delivery BOOLEAN DEFAULT false,
                          min_order_amount INTEGER DEFAULT 0,
                          opening_time VARCHAR(10),
                          closing_time VARCHAR(10),
                          order_mode VARCHAR(50),
                          prep_time VARCHAR(50),
                          created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                          updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                          FOREIGN KEY (restaurant_id) REFERENCES restaurants(id) ON DELETE CASCADE
);
