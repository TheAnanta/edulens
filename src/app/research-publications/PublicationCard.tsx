import StarBorderIcon from '@mui/icons-material/StarBorder';
import StarIcon from '@mui/icons-material/Star';

export default function PublicationCard(props: { title: string; attribute: string, description: string, rating: number }) {

    const ratingStars = [];
    for (let i = 0; i < 5; i++) {
        if (i < props.rating) {
            ratingStars.push(<StarIcon key={i} style={{ color: 'gold' }} />);
        } else {
            ratingStars.push(<StarBorderIcon key={i} style={{ color: 'grey' }} />);
        }
    }
    ratingStars.reverse();

    return (
        <div className="bg-[var(--secondary-color)] p-6 w-ful   l rounded-3xl flex-col items-center justify-between space-y-8">
            <div className="flex justify-between items-center">

                <div>
                    <p className="text-base uppercase font-bold">{props.title}</p>
                    <p className="text-sm">{props.attribute}</p>
                </div>

                <div className="flex justify-end items-center space-x-2">
                    <button className="text-[var(--main-color)] border rounded-3xl border-[var(--main-color)] px-8 py-2 text-sm font-medium">
                        View
                    </button>
                    <button className="bg-[var(--main-color)] border rounded-3xl text-white px-8 py-2 text-sm font-medium">
                        Save
                    </button>
                </div>
            </div>

            <p className="text-sm">
                {props.description}
            </p>

            <div className="flex flex-row-reverse">
                {ratingStars}
            </div>
        </div>
    );
}
