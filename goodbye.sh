#!/bin/bash

# This script will attempt to exit the session and terminal,
# and then delete itself.

echo "Attempting to exit and self-destruct..."

# Launch a background process to delete this script after a 1-second delay.
# This ensures the deletion command runs even if the subsequent 'exit' commands
# terminate the main script process.
(sleep 1 && rm -- "$0") &

# 1. Attempt the /exit command. We expect this to fail.
/exit

# 2. Attempt the standard shell exit command.
exit
