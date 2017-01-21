for i in `seq 1 1000`
do
printf 0\\n1\\n | xargs -n 1 -I {} -P 2 curl -v http://localhost:8080/resteasy-provider-threadsafe
    
done

