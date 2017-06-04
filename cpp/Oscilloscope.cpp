#include "OscilloScope.h"

const char* CPP_BASE_STRING = "cpp says hello world to %s:%s";

const char* getOscilloscopeServer(const char* ip, const char* port) {
  char* concatenedString = new char[strlen(CPP_BASE_STRING) + strlen(ip) + strlen(port)];
	sprintf(concatenedString, CPP_BASE_STRING, ip, port);
	return concatenedString;
}
