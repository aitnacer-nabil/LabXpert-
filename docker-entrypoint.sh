#!/bin/sh
set -e

# Start the PostgreSQL server
su-exec postgres pg_ctl -D /var/lib/postgresql/data start

# Check if the user 'nabil' already exists
if ! su-exec postgres psql -tAc "SELECT 1 FROM pg_roles WHERE rolname='nabil'" | grep -q 1; then
    # Create the user 'nabil' if it doesn't exist
    su-exec postgres psql -v ON_ERROR_STOP=1 --username "$POSTGRES_USER" <<-EOSQL
        CREATE USER nabil WITH PASSWORD 'root';
    EOSQL
fi

# Check if the database 'labxtech' already exists
if ! su-exec postgres psql -tAc "SELECT 1 FROM pg_database WHERE datname='labxtech'" | grep -q 1; then
    # Create the database 'labxtech' if it doesn't exist
    su-exec postgres psql -v ON_ERROR_STOP=1 --username "$POSTGRES_USER" <<-EOSQL
        CREATE DATABASE labxtech;
        GRANT ALL PRIVILEGES ON DATABASE labxtech TO nabil;
    EOSQL
fi

# Stop the PostgreSQL server
su-exec postgres pg_ctl -D /var/lib/postgresql/data stop

# Execute the provided CMD command
exec "$@"
