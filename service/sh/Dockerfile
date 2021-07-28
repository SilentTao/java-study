FROM hub.vipkid.com.cn/devops/centos6.8-jdk1.8.0:v1.7

MAINTAINER ops@vipkid.com.cn

RUN mkdir -p /opt/vipkid/message-pigeon
COPY . /opt/vipkid/message-pigeon



RUN ln -s /opt/vipkid/message-pigeon/vkcat-agent-1.0.12 /opt/vipkid/vkcat-agent-1.0.12 || true

RUN chown -R ec2-user:ec2-user /opt/vipkid/message-pigeon
WORKDIR /opt/vipkid/message-pigeon
EXPOSE 8080