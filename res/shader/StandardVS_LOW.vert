#version 330 core

in vec3 position;

out vec2 textureCoords;
out vec3 fragmentPosition;
out vec2 finalLightPositions[10];

uniform mat4 transformationMatrix;
uniform mat4 projectionMatrix;
uniform mat4 viewMatrix;
uniform vec2 sizeVector;


void main(void)
{
	vec3 newPosition = vec3(position.x * (sizeVector.x / 2), position.y * (sizeVector.y / 2), position.z);
	mat4 viewProjectionMatrix = projectionMatrix * viewMatrix;
	vec4 worldPosition = viewProjectionMatrix * transformationMatrix * vec4(newPosition, 1.0);
	gl_Position =  worldPosition;
	textureCoords = vec2((position.x + 1.0) / 2.0, 1 - (position.y + 1.0) / 2.0);
	fragmentPosition = (transformationMatrix * vec4(newPosition, 1.0)).xyz;
}