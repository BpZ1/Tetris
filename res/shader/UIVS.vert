#version 330 core

in vec2 position;

out vec2 textureCoords;

uniform mat4 transformationMatrix;
uniform mat4 projectionMatrix;
uniform vec2 sizeVector;
uniform vec2 scaleVector;

void main(void)
{
	vec3 newPosition = vec3(position.x * (sizeVector.x / 2), position.y * (sizeVector.y / 2), -1.0);
	vec3 endPosition = vec3(newPosition.x / scaleVector.x, newPosition.y / scaleVector.y, newPosition.z);
	gl_Position = projectionMatrix * transformationMatrix * vec4(endPosition, 1.0);
	textureCoords = vec2((position.x + 1.0) / 2.0, 1 - (position.y + 1.0) / 2.0);
}