const SocialMedial = [
  { X: "link" },
  { Instagram: "link" },
  { YouTube: "link" },
];

export default function Footer() {
  return (
    <div className="absolute bottom-4 right-4 w-full text-right flex justify-end items-center text-sm space-x-3">
      {SocialMedial.map((item, index) => (
        <p key={index} className="text-gray-500">{Object.keys(item)[0]}</p>
      ))}

      <p className="text-black">
        © GITAM (Deemed to Be University) 2024. All Rights Reserved
      </p>
    </div>
  );
}
