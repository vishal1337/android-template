#!/bin/sh
echo "Performing Code Fixes..."

OUTPUT="/tmp/analysis-result"
./gradlew spotlessApply ktlintformat --daemon >${OUTPUT}
EXIT_CODE=$?
if [ ${EXIT_CODE} -ne 0 ]; then
    cat ${OUTPUT}
    rm ${OUTPUT}
    echo "*********************************************"
    echo "            Code Fixing Failed               "
    echo "        Please fix the above issues          "
    echo "*********************************************"
    exit ${EXIT_CODE}
else
    rm ${OUTPUT}
    echo "*********************************************"
    echo "             Code Fixing Complete            "
    echo "*********************************************"
fi
