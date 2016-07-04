#!/usr/bin/env bash

# Create database if not exist
psql -U postgres -tc "SELECT 1 FROM pg_database WHERE datname = 'flyway_test'" | grep -q 1 || psql -U postgres -c "CREATE DATABASE flyway_test"