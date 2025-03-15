FROM ubuntu:24.0.4

# copy arthas
COPY --from=hengyunabc/arthas:latest /opt/arthas /opt/arthas

COPY ./ThreadOOM /

CMD ["/ThreadOOM", "2"]